package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CraftEnchantJavelinFragment extends AttackSkill {
    public CraftEnchantJavelinFragment() {
        this.setName("크래프트:인챈트 자벨린(파편)");
        this.setDamage(200.0 + 170);
        this.setAttackCount(1L);
        this.setDotDuration(1000L);
        this.setInterval(300L);
        this.setLimitAttackCount(2L);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.addFinalDamage(0.5833333333);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
