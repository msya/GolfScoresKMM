//
//  TournamentRepository.swift
//  iosApp
//
//  Created by Mohit S on 1/15/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class TournamentRepository: ObservableObject {
    
    let simulator = TournamentFactory() .createRoundSimulator()
    
    @Published var players: [Player] = []
    
    func getPlayers() async {
        simulator.getPlayers().watch { players in
            print(players)
        }

    }
}
