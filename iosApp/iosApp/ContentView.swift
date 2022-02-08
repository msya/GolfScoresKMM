import SwiftUI
import shared

struct ContentView: View {

    @StateObject var repository = TournamentRepository()
    
	var body: some View {
        Text("Hello World").task {
            await repository.getPlayers()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
