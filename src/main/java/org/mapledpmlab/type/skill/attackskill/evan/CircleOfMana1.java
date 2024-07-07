package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CircleOfMana1 extends AttackSkill {
    public CircleOfMana1() {
        this.setName("서클 오브 마나(1타)");
        this.setDamage(555.0);
        this.setAttackCount(4L);
        this.setDelay(210L);
        this.setRelatedSkill(new CircleOfMana2());
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
