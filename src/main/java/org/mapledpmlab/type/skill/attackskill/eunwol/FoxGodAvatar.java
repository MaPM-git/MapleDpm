package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxGodAvatar extends AttackSkill {
    public FoxGodAvatar() {
        this.setName("여우신의 현신");
        this.setDamage(440.0);
        this.setCooldown(6.0);
        this.setAttackCount(13L + 1);   // 귀참-보너스 어택
        this.setAddDamage(20L + 20);    // 귀참-리인포스, 보스 킬러
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
