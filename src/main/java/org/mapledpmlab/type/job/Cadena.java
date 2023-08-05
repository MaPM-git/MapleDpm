package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.ReuseFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

public class Cadena extends Job {

    public Cadena() {
        // 기본
        super();
        this.setDescription("카데나");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);
        this.addObject(new ReuseBossAbnormal());
        this.addObject(new ReuseFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Noblesse());
        this.addObject(new LukUnion());
        this.addPerXMainStat(20L);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (318 + 196 + 72 + 246));
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addMainStat(50L);          // 콜렉팅 포리프

        // 2차
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);
        this.addAtt(10L);               // 퀵서비스 마인드 I
        this.addCriticalDamage(5.0);
        this.addCriticalP(10.0);

        // 3차
        this.addIgnoreDefenseList(20L);  // 베이직 디텍션

        // 4차
        this.addAtt(31L);               // 웨폰 엑스퍼트
        this.addCriticalP(31.0);
        this.addCriticalDamage(16.0);
        this.addAtt(31L);               // 퀵서비스 마인드 II
        this.addCriticalDamage(11.0);
        this.addCriticalP(11.0);

        // 5차
        this.addAtt(30L);               // 레디 투 다이
    }

    public Long getFinalSubStat2() {
        return (long) Math.floor(
                this.getOtherStat1()
                        * (1 + this.getAllStatP() * 0.01));
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat() + getFinalSubStat2()) * 0.01
                        * Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
