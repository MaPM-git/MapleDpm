package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TerritoryEnd extends AttackSkill {
    public TerritoryEnd() {
        this.setName("테리토리(종료)");
        this.setDamage(550.0 + 305);
        this.setAttackCount(12L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(11000L - 420);
    }
}
