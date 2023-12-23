package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedFinalAttackWildHunter extends AttackSkill {
    public AdvancedFinalAttackWildHunter() {
        this.setName("어드밴스드 파이널 어택");
        this.setAddDamage(25L);     // 농장
        this.setAttackCount(1L);
        this.setDamage(212.0);      // 쓸컴뱃 포함
        this.setProp(71L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
    }
}
