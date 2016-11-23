# word wrap kata
we worked on the word wrap kata

# acceptance test (from Uncle Bob himself)

```java
@Test
public void acceptanceTest() {
  assertWrapped(
    "Four score and seven years ago our fathers brought forth upon this continent",
    7,
    "Four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt");
}
```
