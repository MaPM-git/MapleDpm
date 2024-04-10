package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kinesis.PsychicGroundBuff;

public class PsychicGround extends AttackSkill {
    public PsychicGround() {
        this.setName("싸이킥 그라운드");
        this.setDamage(1015.0);
        this.setDelayByAttackSpeed(360L);
        this.setAttackCount(4L);
        this.setCooldown(30.0);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new PsychicGroundBuff());
    }
}
