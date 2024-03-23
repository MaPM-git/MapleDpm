package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GloryWingEnchantJavelin extends AttackSkill {
    public GloryWingEnchantJavelin() {
        this.setName("글로리 윙:인챈트 자벨린");
        this.setDamage(925.0 + 170 + 205);
        this.setDelayByAttackSpeed(540L);
        this.setAttackCount(6L + 1);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new GloryWingEnchantJavelinMagicMissile());
        this.getMultiAttackInfo().add(140L);
        this.getMultiAttackInfo().add(140L);
        this.getMultiAttackInfo().add(140L);
    }
}
