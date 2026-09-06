# cloud-itonami-assoc-9411-fra-medef

Industry rule/history catalog for **MEDEF** (Mouvement des entreprises
de France) — the THIRTY-FOURTH entry aligned to **ISIC 9411**
(activities of business, employers, and professional membership
organizations), alongside
[`-9411-deu-bdi`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-deu-bdi)
(Germany) and 32 other national industry/employers associations.
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

The **second** entry in the 16-country major-economy campaign opened
at tick 173. France now has real, individually verified facts across
**all three axes**.

## What is in the catalog, and how well sourced each part is

13 entries. They are **not** equally well sourced, and the catalog says
which is which rather than presenting one confidence level:

| Entries | `:url-provenance` | Read from |
|---|---|---|
| 2 (history) | `:wikipedia-corroborated` | `fr.wikipedia.org` — the weakest evidence here, and labelled as such |
| 5 (constitution, seat, duration, composition, dues) | `:official-medef-com` | MEDEF's own **statuts**, the PDF MEDEF publishes |
| 6 (representativeness regime) | `:official-legifrance` | **Legifrance** — Code du travail arts. L2151-1 / L2152-1 / L2152-4, LOI n° 2014-288 du 5 mars 2014, and the two most recent arrêtés |

Every URL in the catalog was retrieved before being written down; a
citation that could not be fetched was not added.

### Why the arrêtés are here, and why the superseded one is kept

MEDEF's standing is not self-declared. Under the Code du travail it is
**conferred by ministerial arrêté**, re-measured on a cycle, and it
carries a weighting. The catalog keeps both the current arrêté
(8 juillet 2025 — MEDEF at 63,42 %) and the one it replaced
(9 février 2024 — MEDEF at 69,21 %), so that representativeness reads
as something periodically re-measured rather than as a fixed
attribute. The 2024 entry is retained **deliberately** and says in its
own title that it was superseded.

### A corroboration, recorded rather than silently merged

The statuts PDF's own cover page lists the general assemblies that
adopted and amended it, and the earliest is **27 octobre 1998** — the
same date the pre-existing Wikipedia-sourced entry gives for MEDEF's
inauguration. That date now has a primary-source witness too. The
Wikipedia entry's provenance is left **unchanged**, because its URL is
still the Wikipedia article; relabelling a source that was not re-read
would overstate what was checked.

### A known limit, stated rather than papered over

The statuts PDF is published under a filename carrying `11-2021`, but
the most recent general assembly printed on its own cover page is
**2 juillet 2019**. `:last-revised-date` follows the cover page,
because that is what the instrument itself asserts; the filename is
not treated as a date.

### The original discrepancy, still resolved and documented

`en.wikipedia.org`'s own infobox and article body **disagree with
each other** on CNPF's (MEDEF's direct predecessor) founding year —
the infobox says 1945, the article text says "founded in 1946".
`fr.wikipedia.org`'s dedicated CNPF article was directly read and
states a precise day-level date, 21 December 1945, which agrees with
the English infobox rather than the English article body. This more
specific, internally-corroborated French-language source is used
here. A personal name appeared in that source text but is deliberately
**not** persisted in this catalog, per standing policy against storing
personal names of office-holders.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on MEDEF's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `src/association_facts.kotoba` — the same catalog as Kotoba, so it
  reaches the Kotoba oracle, wasm and both native ISAs. Kept honest by
  `test/association_facts_kotoba_parity_test.clj`, which compares
  **every field of every entry** against the `.cljc` and compiles the
  module for all four targets it claims.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).
