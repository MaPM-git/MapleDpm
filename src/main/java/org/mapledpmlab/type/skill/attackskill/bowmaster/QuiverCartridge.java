package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuiverCartridge extends AttackSkill {
    public QuiverCartridge() {
        this.setName("퀴버 카트리지");
        this.setAttackCount(1L);
        this.setDamage(442.0);
        this.setProp(60L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(300L);
    }
}
