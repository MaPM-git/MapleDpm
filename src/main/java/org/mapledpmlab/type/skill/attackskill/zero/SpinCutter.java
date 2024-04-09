package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpinCutter extends AttackSkill implements AlphaSkill {
    public SpinCutter() {
        this.setName("어드밴스드 스핀 커터");
        this.setAttackCount(10L);
        this.setDamage(263.0);
        this.setDelayByAttackSpeed(840L);
        this.setRelatedSkill(new SpinCutterBlade());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
