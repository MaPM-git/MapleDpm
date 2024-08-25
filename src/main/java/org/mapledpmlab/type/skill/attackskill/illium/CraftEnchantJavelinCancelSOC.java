package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CraftEnchantJavelinCancelSOC extends AttackSkill {
    public CraftEnchantJavelinCancelSOC() {
        this.setName("크래프트:인챈트 자벨린(캔슬, 소울 오브 크리스탈)");
        this.setDamage(580.0 + 170);
        this.setAttackCount(3L + 1);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new CraftEnchantJavelinFragmentSOC());
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
