package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.windbreaker.PinpointPierceBuff;

public class PinpointPierce extends AttackSkill {
    public PinpointPierce() {
        this.setName("핀포인트 피어스");
        this.setAttackCount(2L);
        this.setDamage(340.0);
        this.setDelayByAttackSpeed(900L);
        this.setRelatedSkill(new PinpointPierceBuff());
        this.setApplyFinalAttack(true);
    }
}
