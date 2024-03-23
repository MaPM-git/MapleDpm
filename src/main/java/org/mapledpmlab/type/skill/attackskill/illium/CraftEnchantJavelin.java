package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CraftEnchantJavelin extends AttackSkill {
    public CraftEnchantJavelin() {
        this.setName("크래프트:인챈트 자벨린");
        this.setDamage(580.0 + 170 + 200 + 97);
        this.setDelayByAttackSpeed(480L);
        this.setAttackCount(3L + 1 + 1);
        this.addFinalDamage(0.66666666666);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new CraftEnchantJavelinFragment());
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
