### doc plausex

https://www.bfs.admin.ch/bfs/fr/home/statistiques/securite-sociale/enquetes/shs/projet-modernisation.html

### code

```
# basic command
xjc -d xjc  -p org.louhan.xjc    /Users/nicolas/Documents/rep/git/plausex/doc/plausex/do-b-13.05-SHS-07.xsd

# with bindings
xjc -b bindings.xjb do-b-13.05-SHS-07.xsd -d generated
```

* using jakarta bind instead of jaxb
