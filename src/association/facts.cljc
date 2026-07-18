(ns association.facts
  "Industry rule/history catalog for MEDEF (Mouvement des entreprises
  de France) -- a 76th industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni, -9411-ken-kam, -9411-can-chamber, -9411-mex-coparmex,
  -9411-ita-confindustria, -9411-nld-vnoncw, -9411-kor-kcci,
  -9411-arg-uia, -9411-bel-feb, -9411-dnk-di, -9411-swe-sn, -9411-fin-ek,
  -9411-tha-fti, -9411-chl-sofofa, -9411-col-andi, -9411-cri-uccaep,
  -9411-ecu-cip, -9411-egy-fei, -9411-pry-uip, -9411-ury-ciu,
  -9411-pol-lewiatan, -9411-prt-cip, -9411-pan-conep, -9411-gtm-cacif,
  -9411-hnd-cohep, -9411-deu-bdi for the first thirty-three) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation). The
  THIRTY-FOURTH entry aligned to ISIC 9411 (activities of business,
  employers, and professional membership organizations). The SECOND
  entry in the 16-country major-economy campaign opened at tick 173
  (ARE/AUS/CHE/ESP/FRA/GBR/IDN/JPN/MYS/NGA/NOR/PHL/TUR/USA/VNM, after
  DEU closed). France now has real, individually verified facts
  across ALL THREE axes (country: cloud-itonami-iso3166-fra
  statute.facts, pre-existing; municipality:
  cloud-itonami-municipality-fra-paris and -fra-lyon, pre-existing;
  association: this entry, the first ISIC-9411-specific one -- France
  already had niche industry entries like cloud-itonami-assoc-6419-
  fra-fbf for banking).

  GENUINE SOURCE DISCREPANCY, resolved and documented: en.wikipedia.org's
  own infobox and article body DISAGREE with each other on CNPF's
  founding year -- the infobox states '1945' while the article text
  says 'founded in 1946'. fr.wikipedia.org's dedicated CNPF article was
  directly read and states verbatim: 'Son assemblée constitutive se
  tient le 21 décembre 1945' (its constituent assembly took place on
  21 December 1945) -- a precise, day-level date that agrees with
  en.wikipedia.org's infobox rather than its article-body text. This
  more specific, internally-corroborated French-language primary
  article is used as the basis for this catalog's date, and the
  English-language discrepancy is documented here transparently rather
  than silently resolved.

  fr.wikipedia.org's separate MEDEF article was also directly read and
  confirms the 27 October 1998 relaunch: MEDEF was inaugurated in
  Strasbourg on that date, succeeding CNPF. A personal name (of the
  individual who performed the inauguration) appeared in the source
  text but is deliberately NOT persisted in this catalog, per standing
  policy against storing personal names of office-holders.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"medef"
   [{:association-rule/id "medef.cnpf-founding-1945-12-21"
     :association-rule/title "CNPF (Conseil National du Patronat Français, MEDEF's direct predecessor)'s constituent assembly took place on 21 December 1945"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :governance-program
     :association-rule/url "https://fr.wikipedia.org/wiki/Conseil_national_du_patronat_fran%C3%A7ais"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "1945-12-21"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}
    {:association-rule/id "medef.renamed-1998-10-27"
     :association-rule/title "MEDEF (Mouvement des entreprises de France) was inaugurated in Strasbourg on 27 October 1998, succeeding CNPF"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :governance-program
     :association-rule/url "https://fr.wikipedia.org/wiki/Mouvement_des_entreprises_de_France"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "1998-10-27"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-fra-medef Wave 0 (ADR-2607141700): "
                 (count (get catalog "medef")) " MEDEF entries seeded "
                 "with fr.wikipedia.org corroboration (resolves an en.wikipedia.org internal "
                 "infobox/article-body discrepancy on CNPF's founding year). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
