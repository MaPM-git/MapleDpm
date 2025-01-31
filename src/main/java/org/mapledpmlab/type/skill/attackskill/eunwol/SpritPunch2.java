package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpritPunch2 extends AttackSkill {
    public SpritPunch2() {
        this.setName("천귀야참(2타)");
        this.setDelayByAttackSpeed(720L);
        this.setAttackCount(10L);
        this.setDamage(2415.0);
        this.setRelatedSkill(new SpritPunch3());
    }
}
