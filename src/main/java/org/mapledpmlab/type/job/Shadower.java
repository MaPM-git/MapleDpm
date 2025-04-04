package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Shadower extends Job {

    public Shadower() {
        // 기본
        super();
        this.setName("섀도어(리웨)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

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
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt((long) (1 + 45));
        this.addMagic(45L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addMainStat(20L);          // 님블 바디

        // 2차
        this.addCriticalP(25.0);        // 크리티컬 엣지
        this.addCriticalDamage(5.0);
        this.addMainStat(20L);          // 대거 액셀레이션
        this.addAtt(30L);               // 카르마
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);
        this.addAtt(15L);               // 실드 마스터리
        this.addFinalDamage(1.1);       // 대거 마스터리

        // 3차
        this.addAtt(25L);               // 그리드

        // 4차
        this.addFinalDamage(1.25);      // 크루얼 스탭
        this.addMainStat(10L);          // 블러디 파킷
        this.addCriticalDamage(20.0);
        this.addAtt(52L);               // 섀도어 인스팅트
        this.addFinalDamage(1.16);
        this.addIgnoreDefenseList(21L);
        this.addAtt(41L);               // 대거 엑스퍼트
        this.addCriticalDamage(15.0);

        // 하이퍼
        this.addCriticalP(25.0);        // 플립 더 코인
        this.addStatXDamage(25L);

        // 5차
        this.addAtt(30L);               // 레디 투 다이

        // 환산 보정
        this.addMainStatP(-72L);
        this.addMainStat(2L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalReuse());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new LukUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    public Long getFinalSubStat2() {
        return (long) Math.floor(
                this.getOtherStat1()
                        * (1 + this.getAllStatP() * 0.01))
                + this.getPerXOtherStat();
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

    @Override
    public Object[] getOpject() {
        Long attMagic;
        Long attMagicP;
        if (this.getAtt() > this.getMagic()) {
            attMagic = this.getAtt();
            attMagicP = this.getAttP();
        } else {
            attMagic = this.getMagic();
            attMagicP = this.getMagicP();
        }
        Object[] result = new Object[]{
                this.getName(), this.getConstant(), this.getMastery() * 2 - 1, this.getLevel(),
                this.getMainStat(), this.getMainStatP() + this.getAllStatP(), this.getPerXMainStat(),
                this.getSubStat(), this.getAllStatP(), this.getPerXSubStat(), this.getOtherStat1(), this.getAllStatP(), this.getPerXOtherStat(), this.getStatDamage(),
                this.getDamage(), String.format("%.2f", this.getFinalDamage() * 100 - 100), this.getBossDamage(),
                String.format("%.4f", this.getIgnoreDefense() * 100), attMagicP, this.getCriticalP(), this.getCriticalDamage(),
                this.getCooldownReductionSec() + "초 / " + this.getCooldownReductionP() + "%", this.getPlusBuffDuration(), this.getReuse(),
                this.getProperty(), "14", "30", "1350", "660", this.getWeaponAttMagic()
        };
        return result;
    }
}
