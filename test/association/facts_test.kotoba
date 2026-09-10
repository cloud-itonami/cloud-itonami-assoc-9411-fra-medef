(ns association.facts-test
  "The MEDEF catalog as a body of sourced claims.

  The risk this catalog carries is not a wrong function; it is an entry that
  looks sourced and is not -- a citation with no publisher, a date invented to
  fill a field, an id reused so one entry silently overwrites another. So the
  assertions below are about provenance and shape, and each is written so that
  a fabricated or careless entry fails it."
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is testing]]
            [association.facts :as facts]))

(def ^:private entries (vec (facts/spec-basis "medef")))

(deftest medef-has-spec-basis
  (is (= 13 (count entries)))
  (is (every? #(str/starts-with? (:association-rule/url %) "https://") entries))
  (is (every? #(= "9411" (:association-rule/isic %)) entries))
  (is (every? #(= "FRA" (:association-rule/country %)) entries)))

(deftest every-entry-names-a-publisher-and-a-retrieval-date
  ;; A citation nobody can attribute is not a citation.
  (doseq [e entries]
    (testing (:association-rule/id e)
      (is (keyword? (:association-rule/url-provenance e)))
      ;; string? first: a missing date must fail this assertion, not throw out
      ;; of re-matches, or the suite reports a crash instead of the defect.
      (let [r (:association-rule/retrieved-at e)]
        (is (string? r) "every entry must record when it was retrieved")
        (is (and (string? r) (some? (re-matches #"\d{4}-\d{2}-\d{2}" r))))))))

(deftest ids-are-distinct
  ;; :association-rule/id is :db.unique/identity, so a duplicate would not be a
  ;; duplicate row -- it would be one row quietly replacing another on transact.
  (is (= (count entries) (count (distinct (map :association-rule/id entries))))))

(deftest dates-that-are-present-are-iso-dates
  (doseq [e entries
          k [:association-rule/established-date :association-rule/last-revised-date]]
    (when-some [v (get e k)]
      (testing (str (:association-rule/id e) " " k)
        (is (re-matches #"\d{4}(-\d{2}-\d{2})?" v))))))

(deftest the-primary-sourced-entries-point-at-the-publisher-they-claim
  ;; Each provenance keyword is a promise about the host the URL resolves to.
  ;; Checking the pair keeps a Legifrance-labelled entry from carrying some
  ;; other site's URL.
  (let [host-for {:official-medef-com "https://www.medef.com/"
                  :official-legifrance "https://www.legifrance.gouv.fr/"
                  :wikipedia-corroborated "https://fr.wikipedia.org/"}]
    (doseq [e entries]
      (testing (:association-rule/id e)
        (let [prefix (host-for (:association-rule/url-provenance e))]
          (is (some? prefix) "provenance must be one the catalog documents")
          (is (str/starts-with? (:association-rule/url e) prefix)))))))

(deftest most-of-the-catalog-is-read-from-the-instrument-not-from-wikipedia
  ;; The two history entries are the weakest evidence here and are the only
  ;; ones allowed to rest on Wikipedia. If that count grows, this fails.
  (let [wiki (filter #(= :wikipedia-corroborated (:association-rule/url-provenance %)) entries)]
    (is (= 2 (count wiki)))
    (is (= #{"medef.cnpf-founding-1945-12-21" "medef.renamed-1998-10-27"}
           (set (map :association-rule/id wiki))))))

(deftest the-representativeness-arretes-are-both-kept
  ;; MEDEF's standing is conferred by arrêté and re-measured on a cycle, so the
  ;; superseded one is retained deliberately and must say so.
  (let [by-id (into {} (map (juxt :association-rule/id identity)) entries)
        current (by-id "medef.arrete-2025-07-08-representativite")
        superseded (by-id "medef.arrete-2024-02-09-representativite")]
    (is (some? current))
    (is (some? superseded))
    (is (str/includes? (:association-rule/title current) "63,42"))
    (is (str/includes? (:association-rule/title superseded) "69,21"))
    (is (str/includes? (:association-rule/title superseded) "remplacé"))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "afep")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["medef" "afep"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["afep"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 10 (count (facts/by-topic "medef" :governance))))
  (is (= 6 (count (facts/by-topic "medef" :statute))))
  (is (= 2 (count (facts/by-topic "medef" :membership))))
  (is (= 2 (count (facts/by-topic "medef" :corporate-form))))
  (is (= 1 (count (facts/by-topic "medef" :finance))))
  (is (empty? (facts/by-topic "medef" :labor)))
  (is (empty? (facts/by-topic "afep" :governance))))
