package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EndlessOminousDream extends AttackSkill implements SpecterSkill {
    public EndlessOminousDream() {
        this.setName("끝나지 않는 흉몽");
        this.setDamage(448.0);
        this.setAttackCount(6L);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
