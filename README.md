treetagger-emf-api
==================

Searching for an easy way to make data coming from the TreeTagger accessible via Java?

This project may help you. We here provide an api written in Java, to read and write data in the format produced by the tool TreeTagger by Helmut Schmid (see: http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/).

"The TreeTagger is a tool for annotating text with part-of-speech and lemma information. It was developed by Helmut Schmid in the TC project at the Institute for Computational Linguistics of the University of Stuttgart. The TreeTagger has been successfully used to tag German, English, French, Italian, Dutch, Spanish, Bulgarian, Russian, Portuguese, Galician, Chinese, Swahili, Slovak, Latin, Estonian and old French texts and is adaptable to other languages if a lexicon and a manually tagged training corpus are available." [see: http://www.cis.uni-muenchen.de/~schmid/tools/TreeTagger/ last visited: 2013-11-18]

The here provided api bases on a EMF model (see: http://www.eclipse.org/modeling/emf/) we created for the TreeTagger data. The model is rather simple and contains the basic elements: Document, Token and Annotation. Annotation is an abstract element, which is specified by the subelements: 
* POSAnnotation (to be used as a part-of-speech annotation), 
* LemmaAnnotation (to be used as a lemma annotation) and 
* AnyAnnotation (to be used as any kind of an annotation, which is representable as a name-value pair and is token based). 

The entire model is shown in the following figure:

![The model of the treetagger-emf-api in EMF, a UML near dialect](./src/main/resources/model/treetagger.png)

---
  Copyright 2009 Humboldt University of Berlin, INRIA.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
