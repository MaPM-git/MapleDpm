package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WindCutter extends AttackSkill implements AlphaSkill {
    public WindCutter() {
        this.setName("윈드 커터");
        this.setAttackCount(8L);
        this.setDamage(265.0);
        this.setDelayByAttackSpeed(720L);
        this.setRelatedSkill(new WindCutterTornado());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
