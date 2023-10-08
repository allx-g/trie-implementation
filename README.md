# Implementing a Trie and Counting Dictionary

An implementation of a Trie in Java. This Trie was used to then implement a Counting Dictionary which stores words along with how many times they've appeared.

This a course project submission for "COSC-211: Data Structures" at Amherst College. The assignment was split into several parts, each of which included implementing a key function of a Trie applying both our theoretical knowledge of the data structure and our ability to understand and work with pre-written code.

## Installation

Download each Java file into a folder then run the following command in the terminal after moving into the correct directory:

```shell
cd path-to-folder-containing-files/
javac Main.java
```

## Usage

Edit Main.java to try out some of the different funtions of a Counting Dictionary. Some sample lines of code have been inserted to test out, but feel free to try different inputs. When editing the code, be sure to recompile before running again. To run, type this command in the terminal.

```shell
java Main
```

Some functions that can be used:

```java
CountingDictionary.insert();
CountingDictionary.delete();
CountingDictionary.find();
CountingDictionary.allKeyValue(); // Returns all words in the dictionary and the counts of each word.
CountingDictionary.prefixMatch();
CountingDictionary.spellCheck1(); // Returns all words that match some part of the given word.
CountingDictionary.spellCheck2(); // Returns all words that are n errors away from the given word.
```

## Contributing

* Source code: https://github.com/allx-g/trie-implementation
* Issue tracker: https://github.com/allx-g/trie-implementation/issues

## Attributions

Project assignment created by Professor Rager at Amherst College for the Spring 2023 semester.