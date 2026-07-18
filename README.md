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

## Sourcing note — a genuine discrepancy, resolved and documented

`en.wikipedia.org`'s own infobox and article body **disagree with
each other** on CNPF's (MEDEF's direct predecessor) founding year —
the infobox says 1945, the article text says "founded in 1946".
`fr.wikipedia.org`'s dedicated CNPF article was directly read and
states a precise day-level date, 21 December 1945, which agrees with
the English infobox rather than the English article body. This more
specific, internally-corroborated French-language source is used
here. `fr.wikipedia.org`'s separate MEDEF article confirms the 27
October 1998 relaunch in Strasbourg, succeeding CNPF — a personal
name appeared in that source text but is deliberately **not**
persisted in this catalog, per standing policy against storing
personal names of office-holders.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on MEDEF's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).
