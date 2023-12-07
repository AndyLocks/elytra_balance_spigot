package illia.kai.elytra_balance_spigot.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Events implements Listener {

    private static final Logger LOGGER = Logger.getLogger(Events.class.getName()); static {
        LOGGER.setLevel(Level.OFF);
        LOGGER.addHandler(new ConsoleHandler());
    }

    private Random random = new Random();

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        LOGGER.log(Level.INFO, "EntityDamageEvent");
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        ItemStack chestPlate = player.getEquipment().getChestplate();
        if (chestPlate == null) return;
        if (chestPlate.getType() != Material.ELYTRA) return;

        LOGGER.log(Level.INFO, "It is elytra");

        // 1 : 4
        int chance = 4;
        if(random.nextInt(chance)+1 == 1) {
            chestPlate.setDurability((short) 432);
            LOGGER.log(Level.INFO, "change durability");
        }
    }
}
