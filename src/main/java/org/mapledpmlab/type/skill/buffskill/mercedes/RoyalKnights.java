package org.mapledpmlab.type.skill.buffskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.mercedes.RoyalKnightsAttack;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RoyalKnights extends BuffSkill {
    public RoyalKnights() {
        this.setName("로얄 나이츠");
        this.setDelayByAttackSpeed(840L);
        this.setCooldown(120.0);
        this.setDuration(20L);
        this.setRelatedSkill(new RoyalKnightsAttack());
        this.setApplyServerLag(true);
    }
}
