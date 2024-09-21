package org.mapledpmlab.type.skill.buffskill.pathfinder;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.pathfinder.ForsakenRelicWave;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class RelicLiberation extends GaugeBuffSkill {
    public RelicLiberation() {
        this.setName("렐릭 해방");
        this.setCooldown(360.0);
        this.setDuration(30L);
        this.setRelatedSkill(new ForsakenRelicWave());
        this.setApplyServerLag(true);
    }
}
