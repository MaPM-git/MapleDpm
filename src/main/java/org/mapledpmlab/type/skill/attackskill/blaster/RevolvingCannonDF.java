package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RevolvingCannonDF extends AttackSkill {
    public RevolvingCannonDF() {
        this.setName("리볼빙 캐논(더블 팡)");
        this.setAttackCount(4L);
        this.setDamage(60.0 + 171);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
