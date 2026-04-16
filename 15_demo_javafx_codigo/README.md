# JavaFX Admin Patterns Lab

Small JavaFX laboratory project bundled inside the main repository.

## Purpose

This demo is not a production system. It is a didactic sandbox to practice:

- shell + sidebar + top bar + workspace layout
- administrative module categories
- variants of each module pattern
- in-memory state instead of database or backend
- reusable component naming
- coherent interactions between modules

## Domain used in the demo

The domain is deliberately trivial: household life.

That keeps the mental load low while still allowing the project to demonstrate:

- dashboard
- catalog / CRUD
- wizard
- expediente / case file
- queue / bandeja
- approval
- transactional flow
- reports
- specialized search
- communication
- documents
- agenda

## Important design choices

- no database
- no real backend
- all data stays in memory
- the goal is coherence and learnability, not persistence
- some actions intentionally create side effects in other modules

Examples:

- approving a request creates an expense
- completing the wizard creates a household expense and a follow-up task
- closing a case creates a document note
- dashboard metrics read the shared in-memory state

## Architectural idea

The lab uses a small shared application state (`AppState`) so modules feel connected without introducing infrastructure noise.

This is useful when you want a demo that teaches patterns and interactions before building a real full stack system.

## Running the lab

Use:

- `run-lab.bat`

## Packaging helpers

Use:

- `build-app-image.bat`
- `build-installer.bat`

Those scripts are intentionally simple and Windows-friendly.

## What this version already demonstrates

- shared in-memory application state
- shell + top bar + sidebar + workspace
- contextual help inside each module
- demo PDF export
- reusable UI helpers for buttons and info panels
- simple cross-module effects between dashboard, wizard, queue, approvals, reports and documents

## Suggested next iteration

- strengthen remaining variants so each category has at least one rock-solid example
- add more consistent inline feedback in the workspace, not only dialogs
- refine comments and naming where a future reusable template may benefit
- keep the project intentionally simple: no database, no backend, only coherent in-memory behavior
