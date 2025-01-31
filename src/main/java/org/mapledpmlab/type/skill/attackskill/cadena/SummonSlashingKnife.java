package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.cadena.SummonSlashingKnifeBuff;

public class SummonSlashingKnife extends AttackSkill {
    public SummonSlashingKnife() {
        this.setName("서먼 슬래싱 나이프");
        this.setDamage(802.0);
        this.setAttackCount(8L);
        this.setDelay(150L + 30);
        this.setCooldown(10.0);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
        this.setRelatedSkill(new SummonSlashingKnifeBuff());
        this.setApplyReuse(true);
    }
}
