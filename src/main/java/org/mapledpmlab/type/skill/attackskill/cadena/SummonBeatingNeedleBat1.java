package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonBeatingNeedleBat1 extends AttackSkill {
    public SummonBeatingNeedleBat1() {
        this.setName("서먼 비팅 니들배트(1타)");
        this.setDamage(505.0);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(480L);
        this.setCooldown(12.0);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
        this.setRelatedSkill(new SummonBeatingNeedleBat2());
        this.setApplyReuse(true);
    }
}
