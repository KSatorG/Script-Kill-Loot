import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.GroundItems;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.GroundItem;
import org.rev317.min.api.wrappers.Npc;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
	
@ScriptManifest(author = "Sator", category = Category.COMBAT, description = "Just testing", name = "FMk", servers = { "Dreamscape" }, version = 2)
public class ForgottenMage extends Script {
	    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    Image _i;
	    @Override
    public boolean onExecute() {
        strategies.add(new Attack());
        provide(strategies);
        return true;
    }
	    @Override
    public void onFinish() {
	    }
    
    public void paint(Graphics g) {
        g.drawRect(0, 40, 100, 200);
    }
    public class Attack implements Strategy {
        

        @Override
        public boolean activate() {
                GroundItem[] loot = GroundItems.getNearest(989,6199,20343);
                if (!Players.getMyPlayer().isInCombat()) {
                        if (loot.length > 0) {
                                if (loot[0].distanceTo() <= 15) {
                                        loot[0].interact(2);
                                        Time.sleep(500);
                                }
                        }
                }                                                                                                   
            return  !Players.getMyPlayer().isInCombat();
      }
	        @SuppressWarnings("deprecation")
        @Override
        public void execute() {
            Npc dbonecunt = Npcs.getClosest(10530);
            if (dbonecunt != null && !dbonecunt.isInCombat() == true) 
		{
               		dbonecunt.interact(1);
                	Time.sleep(2000);
                	Time.sleep(new SleepCondition()
			{
	                	public boolean isValid() 
				{
                        		return Players.getMyPlayer().isInCombat();
                        	}
                    	},3000);
            }
        }
    }
  }
