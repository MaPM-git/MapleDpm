package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxGodClaw1 extends AttackSkill {
    public FoxGodClaw1() {
        this.setName("호신연참(1타)");
        this.setDamage(745.0);
        this.setDelayByAttackSpeed(510L);
        this.setRelatedSkill(new FoxGodClaw2());
        this.setAttackCount(8L + 1);    // 귀참-보너스 어택
        this.setAddDamage(20L + 20);    // 귀참-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
