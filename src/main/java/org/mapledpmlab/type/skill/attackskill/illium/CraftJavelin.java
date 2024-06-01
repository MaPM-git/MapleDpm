package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CraftJavelin extends AttackSkill {
    public CraftJavelin() {
        this.setName("크래프트:자벨린");
        this.setDamage(580.0 + 200 + 97);
        this.setDelayByAttackSpeed(690L);
        this.setAttackCount(3L + 1);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new CraftJavelinFragment());
        this.setApplyFinalAttack(true);
    }
}
