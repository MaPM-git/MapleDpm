package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HeavensDoor extends AttackSkill {
    public HeavensDoor() {
        this.setName("헤븐즈 도어");
        this.setDamage(805.0);
        this.setAttackCount(10L);
        this.setCooldown(60.0);
        this.setDelayByAttackSpeed(360L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setApplyFinalAttack(true);
    }
}
