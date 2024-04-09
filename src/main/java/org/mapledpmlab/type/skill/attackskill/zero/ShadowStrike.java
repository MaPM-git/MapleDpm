package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowStrike extends AttackSkill implements AlphaSkill {
    public ShadowStrike() {
        this.setName("쉐도우 스트라이크");
        this.setAttackCount(8L);
        this.setDamage(195.0);
        this.setDelayByAttackSpeed(660L);
        this.setRelatedSkill(new ShadowStrikeBlade());
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
