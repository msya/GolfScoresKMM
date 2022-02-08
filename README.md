# GolfScoresKMM

Koltin Multplatform Project that interacts with a GraphQL server to display golf scores, player and weather information. <br/>

<img src="https://user-images.githubusercontent.com/1616626/152921056-99e90958-40f3-480b-a847-35952c72b609.png" width="300"/>

The app is setup to use common shared components that interact with the [GraphQL server](https://github.com/msya/GolfScores).


## Android App Architecture

The Android app uses [Molecule](https://github.com/cashapp/molecule) library. A presenter has a composable function that takes in a flow of events
and generates a model. 

<img src="https://user-images.githubusercontent.com/1616626/152921375-92d69d98-6cf3-4bdb-aa6f-e5136f1b9388.png" width="600"/>

