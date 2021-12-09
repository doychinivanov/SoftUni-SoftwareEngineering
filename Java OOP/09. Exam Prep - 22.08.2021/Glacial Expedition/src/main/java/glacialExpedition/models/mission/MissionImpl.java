package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission{

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        Collection<String> currentStateExhibits = state.getExhibits();

        for (Explorer curExplorer : explorers) {

            while (curExplorer.canSearch() && currentStateExhibits.iterator().hasNext()) {

                curExplorer.search();
                String currentItem = currentStateExhibits.iterator().next();
                curExplorer.getSuitcase().getExhibits().add(currentItem);
                currentStateExhibits.remove(currentItem);
            }
        }
    }
}
