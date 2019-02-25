package water.automl.api.schemas3;

import ai.h2o.automl.EventLogItem;
import ai.h2o.automl.EventLogItem.Level;
import ai.h2o.automl.EventLogItem.Stage;
import water.api.API;
import water.api.EnumValuesProvider;
import water.api.Schema;

public class EventLogItemV99 extends Schema<EventLogItem, EventLogItemV99> {

  @API(help="Timestamp for this event, in milliseconds since Jan 1, 1970", direction=API.Direction.OUTPUT)
  public long timestamp;

  @API(help="Importance of this feedback event", valuesProvider = LevelProvider.class, direction=API.Direction.OUTPUT)
  public Level level;

  @API(help="Stage of the AutoML process for this feedback event", valuesProvider = StageProvider.class, direction=API.Direction.OUTPUT)
  public Stage stage;

  @API(help="Message for this event", direction=API.Direction.OUTPUT)
  public String message;

  public static final class LevelProvider extends EnumValuesProvider<Level> {
    public LevelProvider() { super(Level.class); }
  }

  public static final class StageProvider extends EnumValuesProvider<Stage> {
    public StageProvider() { super(Stage.class); }
  }
}