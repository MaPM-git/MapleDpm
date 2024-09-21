package org.mapledpmlab.type.skill.buffskill.cannonshooter;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.cannonshooter.Poolmaker;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PoolmakerBuff extends BuffSkill {
    public PoolmakerBuff() {
        this.setName("풀 메이커");
        this.setDelay(960L);
        this.setCooldown(60.0);
        this.setApplyServerLag(true);
        this.setDuration(30L);
        this.addBuffDamage(30L);
        this.setRelatedSkill(new Poolmaker());
    }
}
