package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrystalSkillMortalSwing extends AttackSkill {
    public CrystalSkillMortalSwing() {
        this.setName("크리스탈 스킬:모탈스윙");
        this.setDamage(500.0 + 102);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
