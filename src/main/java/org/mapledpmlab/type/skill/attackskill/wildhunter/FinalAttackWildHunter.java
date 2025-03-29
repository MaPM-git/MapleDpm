package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackWildHunter extends AttackSkill {
    public FinalAttackWildHunter() {
        this.setName("파이널 어택");
        this.setAddDamage(30L);     // 아티팩트
        this.setAttackCount(1L);
        this.setDamage(650.0);
        this.setProp(71L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
