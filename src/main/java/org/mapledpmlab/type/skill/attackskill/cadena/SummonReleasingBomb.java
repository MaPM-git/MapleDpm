package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonReleasingBomb extends AttackSkill {
    public SummonReleasingBomb() {
        this.setName("서먼 릴리싱 봄");
        this.setDamage(415.0 + 177);
        this.setAttackCount(6L);
        this.setDelay(150L + 30);
        this.setCooldown(8.0);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
        this.getMultiAttackInfo().add(1000L);
        this.setApplyReuse(true);
    }
}
