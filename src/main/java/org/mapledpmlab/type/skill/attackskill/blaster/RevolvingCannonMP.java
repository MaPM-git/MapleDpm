package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RevolvingCannonMP extends AttackSkill {
    public RevolvingCannonMP() {
        this.setName("리볼빙 캐논(매그넘 펀치)");
        this.setAttackCount(4L);
        this.setDamage(675.0);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
