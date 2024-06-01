package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxGodClaw3 extends AttackSkill {
    public FoxGodClaw3() {
        this.setName("호신연참(3타)");
        this.setDamage(795.0);
        this.setDelayByAttackSpeed(570L);
        this.setAttackCount(10L + 1);   // 귀참-보너스 어택
        this.setAddDamage(20L + 20);    // 귀참-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
