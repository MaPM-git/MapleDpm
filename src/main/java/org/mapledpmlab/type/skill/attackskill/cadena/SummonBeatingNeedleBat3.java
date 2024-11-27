package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonBeatingNeedleBat3 extends AttackSkill {
    public SummonBeatingNeedleBat3() {
        this.setName("서먼 비팅 니들배트(3타)");
        this.setDamage(925.0);
        this.setAttackCount(10L);
        this.setDelay(150L + 30);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
    }
}
