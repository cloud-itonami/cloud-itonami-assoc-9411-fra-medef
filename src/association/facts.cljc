(ns association.facts
  "Industry rule/history catalog for MEDEF (Mouvement des entreprises
  de France), aligned to ISIC 9411 (activities of business, employers,
  and professional membership organizations), per ADR-2607141700
  (cloud-itonami-compliance-fact-federation).

  WHERE EACH ENTRY COMES FROM. The two history entries (indices 0-1)
  are corroborated against fr.wikipedia.org and are marked
  :wikipedia-corroborated -- they are the weakest evidence here and are
  labelled as such. Every other entry was read from the instrument
  itself and is marked with the publisher it was read from:

  - :official-medef-com (indices 2-6) -- MEDEF's own statuts, the PDF
    MEDEF publishes on medef.com. Articles 1 (dénomination et objet),
    4 (siège social), 5 (durée), 6 (composition) and 31 (budget -
    cotisations) were each read from that document, not summarised
    from anywhere else.
  - :official-legifrance (indices 7-12) -- the Code du travail articles
    L2151-1, L2152-1 and L2152-4 that define représentativité
    patronale; LOI n° 2014-288 du 5 mars 2014, whose Titre II created
    that regime; and the two most recent arrêtés fixing the list of
    organisations recognised as representative at national and
    interprofessional level.

  WHY THE ARRÊTÉS MATTER HERE. MEDEF's standing is not self-declared:
  it is conferred by a ministerial arrêté under the Code du travail,
  renewed on a cycle, and it carries a measured weighting. Both the
  current arrêté (8 juillet 2025, MEDEF at 63,42 %) and the one it
  replaced (9 février 2024, MEDEF at 69,21 %) are kept, so the catalog
  shows the standing as a thing that is periodically re-measured
  rather than as a fixed attribute. The 2024 entry is retained
  DELIBERATELY as superseded and says so in its title.

  A CORROBORATION, recorded rather than silently merged: the statuts
  PDF's own cover page lists the general assemblies that adopted and
  amended it, and the earliest of those is 27 octobre 1998 -- the same
  date the pre-existing :wikipedia-corroborated entry at index 1 gives
  for MEDEF's inauguration. That date now has a primary-source witness
  as well as a Wikipedia one. The index 1 entry's provenance is left
  unchanged, because its URL is still the Wikipedia article; the
  corroboration is noted here rather than by relabelling a source that
  was not re-read.

  GENUINE SOURCE DISCREPANCY, resolved and documented: en.wikipedia.org's
  own infobox and article body DISAGREE with each other on CNPF's
  founding year -- the infobox states '1945' while the article text
  says 'founded in 1946'. fr.wikipedia.org's dedicated CNPF article was
  directly read and states verbatim: 'Son assemblée constitutive se
  tient le 21 décembre 1945' -- a precise, day-level date that agrees
  with en.wikipedia.org's infobox rather than its article-body text.
  That more specific, internally-corroborated French-language article
  is the basis for index 0, and the English-language discrepancy is
  documented here transparently rather than silently resolved.

  KNOWN LIMIT, stated rather than papered over: the statuts PDF is
  published under a filename carrying '11-2021', but the most recent
  general assembly printed on its own cover page is 2 juillet 2019.
  :last-revised-date follows the cover page, because that is what the
  instrument itself asserts; the filename is not treated as a date.

  A personal name (of the individual who inaugurated MEDEF in 1998)
  appears in the fr.wikipedia.org source text and is deliberately NOT
  persisted here, per standing policy against storing personal names
  of office-holders.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"medef"
   [
    {:association-rule/id "medef.cnpf-founding-1945-12-21"
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
     :association-rule/topic #{:governance}}
    {:association-rule/id "medef.statuts-art1-association-loi-1901"
     :association-rule/title "Statuts art. 1 (Dénomination et objet): sous la dénomination de Mouvement des Entreprises de France (MEDEF), une association de la loi de 1901 est constituée, sous forme de confédération, entre les organisations professionnelles et territoriales d'entreprises, qui adhèrent aux présents statuts"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :constitutive-instrument
     :association-rule/url "https://www.medef.com/uploads/media/default/0019/99/14271-statuts-medef-11-2021.pdf"
     :association-rule/url-provenance :official-medef-com
     :association-rule/established-date "1998-10-27"
     :association-rule/last-revised-date "2019-07-02"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :corporate-form}}
    {:association-rule/id "medef.statuts-art4-siege-paris"
     :association-rule/title "Statuts art. 4 (Siège social): le Mouvement des entreprises de France a son siège au 55 avenue Bosquet, 75007 Paris; il peut être transféré en tout autre endroit par décision du conseil exécutif"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.medef.com/uploads/media/default/0019/99/14271-statuts-medef-11-2021.pdf"
     :association-rule/url-provenance :official-medef-com
     :association-rule/last-revised-date "2019-07-02"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "medef.statuts-art5-duree-illimitee"
     :association-rule/title "Statuts art. 5 (Durée): la durée du Mouvement des entreprises de France n'est pas limitée"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :constitutive-instrument
     :association-rule/url "https://www.medef.com/uploads/media/default/0019/99/14271-statuts-medef-11-2021.pdf"
     :association-rule/url-provenance :official-medef-com
     :association-rule/last-revised-date "2019-07-02"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :corporate-form}}
    {:association-rule/id "medef.statuts-art6-composition"
     :association-rule/title "Statuts art. 6 (Composition): MEDEF est constitué d'organisations professionnelles nationales et d'organisations territoriales (régionales, départementales et locales), qui en sont les membres actifs; des membres associés siègent à l'assemblée générale avec voix consultative et à l'assemblée électorale avec voix délibérative"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :membership-rule
     :association-rule/url "https://www.medef.com/uploads/media/default/0019/99/14271-statuts-medef-11-2021.pdf"
     :association-rule/url-provenance :official-medef-com
     :association-rule/last-revised-date "2019-07-02"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:membership}}
    {:association-rule/id "medef.statuts-art31-cotisations"
     :association-rule/title "Statuts art. 31 (Budget - Cotisations): les ressources se composent des cotisations de ses membres, de l'intérêt des fonds placés et de toutes autres ressources autorisées par la loi; les taux de cotisation sont votés en même temps et dans les mêmes conditions que le budget"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :membership-rule
     :association-rule/url "https://www.medef.com/uploads/media/default/0019/99/14271-statuts-medef-11-2021.pdf"
     :association-rule/url-provenance :official-medef-com
     :association-rule/last-revised-date "2019-07-02"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:membership :finance}}
    {:association-rule/id "medef.ct-l2151-1-criteres-representativite"
     :association-rule/title "Code du travail art. L2151-1: la représentativité des organisations professionnelles d'employeurs est déterminée d'après les critères cumulatifs suivants: 1° le respect des valeurs républicaines; 2° l'indépendance; 3° la transparence financière; 4° une ancienneté minimale de deux ans; puis l'influence et l'audience"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :statute
     :association-rule/url "https://www.legifrance.gouv.fr/codes/article_lc/LEGIARTI000033023411"
     :association-rule/url-provenance :official-legifrance
     :association-rule/last-revised-date "2016-08-08"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :statute}}
    {:association-rule/id "medef.ct-l2152-1-branche"
     :association-rule/title "Code du travail art. L2152-1: dans les branches professionnelles, sont représentatives les organisations professionnelles d'employeurs qui satisfont aux critères de l'article L. 2151-1, disposent d'une implantation territoriale équilibrée au sein de la branche et dont les entreprises adhérentes représentent au moins 8 % des entreprises adhérant aux organisations candidates"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :statute
     :association-rule/url "https://www.legifrance.gouv.fr/codes/article_lc/LEGIARTI000029946324/2014-12-22"
     :association-rule/url-provenance :official-legifrance
     :association-rule/last-revised-date "2014-12-20"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:statute}}
    {:association-rule/id "medef.ct-l2152-4-national-interprofessionnel"
     :association-rule/title "Code du travail art. L2152-4: sont représentatives au niveau national et interprofessionnel les organisations professionnelles d'employeurs qui satisfont aux critères des 1° à 5° de l'article L. 2151-1, dont les organisations adhérentes sont représentatives à la fois dans des branches de l'industrie, de la construction, du commerce et des services, et dont les entreprises et organisations adhérentes représentent au moins 8 % de l'ensemble ou au moins 8 % des salariés"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :statute
     :association-rule/url "https://www.legifrance.gouv.fr/codes/section_lc/LEGITEXT000006072050/LEGISCTA000028689659/"
     :association-rule/url-provenance :official-legifrance
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :statute}}
    {:association-rule/id "medef.loi-2014-288-democratie-sociale"
     :association-rule/title "LOI n° 2014-288 du 5 mars 2014 relative à la formation professionnelle, à l'emploi et à la démocratie sociale (NOR ETSX1400015L): son Titre II (Démocratie sociale) porte la représentativité patronale, la représentativité syndicale et le financement des organisations professionnelles d'employeurs et syndicales"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :statute
     :association-rule/url "https://www.legifrance.gouv.fr/loda/id/JORFTEXT000028683576"
     :association-rule/url-provenance :official-legifrance
     :association-rule/established-date "2014-03-05"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :statute}}
    {:association-rule/id "medef.arrete-2025-07-08-representativite"
     :association-rule/title "Arrêté du 8 juillet 2025 (NOR TSST2509392A, JORF du 9 juillet 2025 n° 0158) art. 1: sont reconnues représentatives au niveau national et interprofessionnel le Mouvement des entreprises de France (MEDEF), la Confédération des petites et moyennes entreprises (CPME) et l'Union des entreprises de proximité (U2P); art. 2 fixe la pondération du MEDEF à 63,42 %"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :statute
     :association-rule/url "https://www.legifrance.gouv.fr/jorf/id/JORFTEXT000051862327"
     :association-rule/url-provenance :official-legifrance
     :association-rule/established-date "2025-07-08"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :statute}}
    {:association-rule/id "medef.arrete-2024-02-09-representativite"
     :association-rule/title "Arrêté du 9 février 2024 (NOR TSST2401325A, JORF du 16 février 2024 n° 0039) art. 1: mêmes trois organisations reconnues représentatives au niveau national et interprofessionnel, pondération du MEDEF alors fixée à 69,21 % — remplacé par l'arrêté du 8 juillet 2025"
     :association-rule/association "medef"
     :association-rule/isic "9411"
     :association-rule/country "FRA"
     :association-rule/kind :statute
     :association-rule/url "https://www.legifrance.gouv.fr/jorf/id/JORFTEXT000049151004"
     :association-rule/url-provenance :official-legifrance
     :association-rule/established-date "2024-02-09"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :statute}}]})

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
                 (count (get catalog "medef")) " MEDEF entries. Two are history "
                 "entries corroborated against fr.wikipedia.org (and marked "
                 ":wikipedia-corroborated); the rest were read from the instruments "
                 "themselves -- MEDEF's own statuts on medef.com, and on Legifrance the "
                 "Code du travail representativeness articles, LOI n. 2014-288, and the "
                 "arretes recognising MEDEF as representative. "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
