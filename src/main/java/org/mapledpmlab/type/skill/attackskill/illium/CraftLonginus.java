package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CraftLonginus extends AttackSkill {
    public CraftLonginus() {
        this.setName("크래프트:롱기누스");
        this.setDamage(1790.0);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(12L);
        this.setAddDamage(20L);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
