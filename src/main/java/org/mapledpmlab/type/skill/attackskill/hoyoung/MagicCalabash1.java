package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagicCalabash1 extends AttackSkill {
    public MagicCalabash1() {
        this.setName("마봉 호로부(흡수)");
        this.setDelayByAttackSpeed(480L);
        this.setRelatedSkill(new MagicCalabash2());
    }
}
