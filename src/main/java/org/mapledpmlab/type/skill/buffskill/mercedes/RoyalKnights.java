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
        this.setDelay(1680L);
        this.setCooldown(180.0);
        this.setDuration(30L);
        this.setRelatedSkill(new RoyalKnightsAttack());
        this.setApplyServerLag(true);
    }
}
