# Simple cache server

IN PROGRESS

Simple spring server that allows for caching string values.
Caches are organized by user and by projects that user owns.

## Why?

If in CI/CD environment there is long compliation (for examle in rust projects) or test deployemnts (for example
in Salesforce projects) attached to pull request verification,
if two commits are made one after another, results of first verification run will be useless.
It will waste resources

Also, I wanted a taste of server side rendering done in Java (and Kotlin)

## TODO

- support for keys
- support for users
- users sharing access to projects
- batch running and clearing old keys
- authorziation
- configure project to use real credentials
- make db avalible only for server
- db persistence (dont clear db)
- some frontend