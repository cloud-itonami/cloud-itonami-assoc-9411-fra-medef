(ns association.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest medef-has-spec-basis
  (let [sb (facts/spec-basis "medef")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:association-rule/url %) "https://") sb))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "FRA" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "afep")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["medef" "afep"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["afep"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "medef" :governance))))
  (is (empty? (facts/by-topic "medef" :labor)))
  (is (empty? (facts/by-topic "afep" :governance))))
